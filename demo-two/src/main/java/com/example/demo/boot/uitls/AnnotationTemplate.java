package com.example.demo.boot.uitls;

/**
 * @description: AnnotationTemplate <br>
 * @date: 2020/2/7 17:23 <br>
 * @author: PWB <br>
 * @version: 1.0 <br>
 */
public class AnnotationTemplate {

//文件头 注释模板
    /**
     * @description: ${NAME} <br>
     * @date: ${DATE} ${TIME} <br>
     * @author: PWB <br>
     * @version: 1.0 <br>
     */

    //方法注释模板

    /**
     *  *
     * @description: $description$ <br>
     * @version: 1.0 <br>
     * @date: $date$ $time$ <br>
     * @author: PWB <br>
    $params$ <br>
     * @return $return$ <br>
     */

    /*
      methodName()
      date()
      time()
      groovyScript("def result=''; def params=\"${_1}\".replaceAll('[\\\\[|\\\\]|\\\\s]', '').split(',').toList(); for(i = 0; i < params.size(); i++) {result+=' * @param ' + params[i] + ((i < params.size() - 1) ? ' <br>\\n' : '')}; return result", methodParameters())
      methodReturnType()
      */

}
