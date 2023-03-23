package com.example.hututest.mockito;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ArticleManagerTest  {

       @Rule
       public MockitoRule rule = MockitoJUnit.rule();

       @Captor
       private ArgumentCaptor<List<String>> captor;

       @Test
       public final void shouldContainCertainListItem() {
              List<String> asList = Arrays.asList("someElement_test", "someElement");
              final List<String> mockedList = mock(List.class);
              mockedList.addAll(asList);

              verify(mockedList).addAll(captor.capture());
              final List<String> capturedArgument = captor.getValue();
              assertThat(capturedArgument, hasItem("someElement"));
       }
}