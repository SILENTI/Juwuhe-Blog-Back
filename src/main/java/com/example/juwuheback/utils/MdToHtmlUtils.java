package com.example.juwuheback.utils;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.options.MutableDataSet;

public class MdToHtmlUtils {

    /**
     * 将markdown文件语法转html
     *
     * @param md
     * @return
     */
    public static String convert(String md) {
        MutableDataSet options = new MutableDataSet();

        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        // You can re-use parser and renderer instances
        Node document = parser.parse(md);
        String html = renderer.render(document);  // "<p>This is <em>Sparta</em></p>\n"
        return html;
    }

    public static void main(String[] args) {
    }

}
