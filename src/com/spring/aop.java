package com.spring;

public class aop {
}
class AccountService{
    public static void main(String[] args) {

    }

    public void transfer() {
        System.out.println("调用dao,完成转账业务.");
    }
}

class AccountAdvice implements MethodInterceptor{

}