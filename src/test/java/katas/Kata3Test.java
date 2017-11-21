package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;


public class Kata3Test {

    @Test
    public void testSize() {
        Assert.assertThat(Kata3.execute().size(), equalTo(4));
    }

    @Test
    public void testResult() {
        Assert.assertThat(Kata3.execute(), equalTo(ImmutableList.of(70111470, 654356453, 65432445, 675465)));
    }
}
