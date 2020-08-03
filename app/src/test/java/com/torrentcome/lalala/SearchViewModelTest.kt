package com.torrentcome.lalala

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import com.torrentcome.lalala.base.RxSchedulerRule
import com.torrentcome.lalala.base.testObserver
import com.torrentcome.lalala.data.RepoImpl
import com.torrentcome.lalala.di.ApiModule
import com.torrentcome.lalala.ui.search.SearchViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule


class SearchViewModelTest {

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val rxSchedulerRule = RxSchedulerRule()

    private lateinit var classUnderTest: SearchViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        val giphyService = ApiModule.provideGiphyService()
        val repo = RepoImpl(giphyService)
        classUnderTest = SearchViewModel(repo)
    }

    @Test
    fun `when init then Command is Start`() {
        val command = classUnderTest.searchO.testObserver()
        Truth.assert_().that(command.observedValues.first())
            .isEqualTo(SearchViewModel.Command.Start)
    }

    @Test
    fun `when request then command pass by Start, Loading, Success`() {
        val commandList = classUnderTest.searchO.testObserver()
        classUnderTest.config()
        classUnderTest.onEditInputStateChanged("q")
        val that = commandList.observedValues
        println(that.toString())
        Truth.assert_().that(that[0] is SearchViewModel.Command.Start).isTrue()
        Truth.assert_().that(that[1] is SearchViewModel.Command.Loading).isTrue()
        Truth.assert_().that(that[2] is SearchViewModel.Command.Success).isTrue()
    }

    @Test
    fun `when request then success url is not empty`() {
        val commandList = classUnderTest.searchO.testObserver()
        classUnderTest.config()
        classUnderTest.onEditInputStateChanged("q")
        val that = commandList.observedValues
        println(that.toString())
        Truth.assert_().that(
            (that[2] as SearchViewModel.Command.Success)
                .list.isNotEmpty()
        )
            .isTrue()
    }
}