package com.example.hututest.mockito;


import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class MockItoTest {
    @Test(expected = IOException.class)
    public void testForIOException() throws IOException {
        // 创建并配置 mock 对象
        OutputStream mockStream = mock(OutputStream.class);
        doThrow(new IOException()).when(mockStream).close();
//        doThrow(new IOException()).when(mockStream).close();

        // 使用 mock
        OutputStreamWriter streamWriter= new OutputStreamWriter(mockStream);
        streamWriter.close();
    }
}