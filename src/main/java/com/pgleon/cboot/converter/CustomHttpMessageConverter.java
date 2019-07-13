package com.pgleon.cboot.converter;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.google.common.collect.ImmutableMap;
import com.pgleon.cboot.pojo.APIErrorResponse;
import com.pgleon.cboot.pojo.PagingApiResponse;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;

/**
 * @author leon
 * @Date: 2019-07-10 12:04
 * @Description: 自定义MessageConverter,格式化返回值
 */
public class CustomHttpMessageConverter extends FastJsonHttpMessageConverter {

    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        if (object instanceof APIErrorResponse) {
            super.writeInternal(format(object, "error"), outputMessage);
        } else if (object instanceof PagingApiResponse) {
            super.writeInternal(pagingFormat((PagingApiResponse) object), outputMessage);
        } else {
            super.writeInternal(format(object, "date"), outputMessage);
        }
        super.writeInternal(object, outputMessage);
    }


    private ImmutableMap<Object, Object> format(Object obj, String name) {
        return ImmutableMap.builder()
                .put(name, obj).build();
    }

    private static ImmutableMap<Object, Object> pagingFormat(PagingApiResponse pagingResponse) {
        ImmutableMap<String, Object> paging = ImmutableMap.<String, Object>builder()
                .put("page", pagingResponse.getPage())
                .put("pageSize", pagingResponse.getPageSize())
                .put("total", pagingResponse.getTotal())
                .put("hasMore", pagingResponse.isHasMore())
                .build();
        return ImmutableMap.builder()
                .put("data", pagingResponse.getData())
                .put("paging", paging)
                .build();
    }
}
