package com.bjpowernode.vo;

public class TestClass {
    private Integer testID;
    private String testName;


    @Override
    public String toString() {
        return "TestClass{" +
                "testID=" + testID +
                ", testName='" + testName + '\'' +
                '}';
    }

    public Integer getTestID() {
        return testID;
    }

    public void setTestID(Integer testID) {
        this.testID = testID;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }
}
