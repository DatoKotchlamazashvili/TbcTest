package com.example.davittest.coroutine_homework_dont_mind

import com.example.davittest.MainCoroutineRuleclass
import com.example.davittest.TestDispatchers
import com.google.common.truth.Truth.assertThat
import junit.framework.TestCase.fail
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import kotlin.IllegalArgumentException
import kotlin.coroutines.coroutineContext

class FindPrimeNumberAtIndexTest {

    @get:Rule
    val mainCoroutineRUle = MainCoroutineRuleclass(StandardTestDispatcher())



    @Test
    fun `when index 3 then 5`() = runTest{

        val disptacher = coroutineContext[CoroutineDispatcher]!!

        val result = findPrimeNumberAtIndex(3,disptacher)

        assertThat(result).isEqualTo(5)
    }

    @Test
    fun `when index 1 then 2`() = runTest{

        val disptacher = coroutineContext[CoroutineDispatcher]!!

        val result = findPrimeNumberAtIndex(1,disptacher)

        assertThat(result).isEqualTo(2)
    }

    @Test
    fun `when index 0 then exception`() = runTest {
        val dispatcher = coroutineContext[CoroutineDispatcher]!!

        try {
            findPrimeNumberAtIndex(0, dispatcher)
            fail("Expected IllegalArgumentException to be thrown")
        } catch (e: IllegalArgumentException) {
            assertThat(e).hasMessageThat().isEqualTo("Index should be greater than 0")
        }
    }


}