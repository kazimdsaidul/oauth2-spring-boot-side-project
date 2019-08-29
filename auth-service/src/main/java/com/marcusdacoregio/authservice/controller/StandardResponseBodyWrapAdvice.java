package com.marcusdacoregio.authservice.controller;

//@ControllerAdvice
//public class StandardResponseBodyWrapAdvice implements ResponseBodyAdvice<Object> {
//    @Override
//    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
//        return (AnnotationUtils.findAnnotation(returnType.getContainingClass(), ResponseBody.class) != null ||
//                returnType.getMethodAnnotation(ResponseBody.class) != null);
//    }
//
//
//
//    @Override
//    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
//        ApiResponseDTO<Object> resp = new ApiResponseDTO<>();
//        resp.setVersion("1.0");
//        resp.setSuccess(true);
//        resp.setData(body);
//
//
////        if (body instanceof String) {
////            return JSON.toJSONString(result);
////        }
//        return resp;
//    }
//}
