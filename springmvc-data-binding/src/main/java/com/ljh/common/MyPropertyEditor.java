package com.ljh.common;

import com.ljh.object.User;

import java.beans.PropertyEditorSupport;

/**
 * PropertyEditor
 * 局部使用，一般配合 WebDataBinder
 *
 * @author ljh
 * created on 2019/10/29 9:35
 */
public class MyPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        User u = new User();
        String[] textArray = text.split(",");
        u.setName(textArray[0]);
        u.setAge(Integer.parseInt(textArray[1]));
        this.setValue(u);
    }

    public static void main(String[] args) {
        MyPropertyEditor editor = new MyPropertyEditor();
        editor.setAsText("tom,22");
        System.out.println(editor.getValue());
    }
}
