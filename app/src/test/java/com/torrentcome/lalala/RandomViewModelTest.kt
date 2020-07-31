package com.torrentcome.lalala

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import com.torrentcome.lalala.api.GiphyService
import com.torrentcome.lalala.base.RxSchedulerRule
import com.torrentcome.lalala.base.testObserver
import com.torrentcome.lalala.data.Repo
import com.torrentcome.lalala.ui.random.RandomViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule


class RandomViewModelTest {

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val rxSchedulerRule = RxSchedulerRule()

    @Mock
    private lateinit var giphyService: GiphyService

    @Mock
    private lateinit var repo: Repo

    @InjectMocks
    private lateinit var classUnderTest: RandomViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        repo = Repo(giphyService)
    }


    @Test
    fun `when Init then Command is Start`() {
        val command = classUnderTest.randomO.testObserver()
        Truth.assert_().that(command.observedValues.first())
            .isEqualTo(RandomViewModel.Command.Start)
    }

    @Test
    fun `when Request then Command pass by Start, Loading, Success`() {
        val commandList = classUnderTest.randomO.testObserver()

        classUnderTest.getRandom()

        Truth.assert_()
            .that(commandList.observedValues)
            .isEqualTo(
                listOf(
                    RandomViewModel.Command.Start,
                    RandomViewModel.Command.Loading,
                    RandomViewModel.Command.Success()
                )
            )
    }

}