package by.tms.hibernate.runner;

import by.tms.hibernate.service.OperationService;
import by.tms.hibernate.service.UserService;
import by.tms.hibernate.entity.Operation;
import by.tms.hibernate.entity.User;

public class Main {

    public static void main(String[] args) {
        UserService userService = new UserService();
        OperationService operationService = new OperationService();

        User user = new User("MyName", "EasyLogin", "HardPassword");
        Operation op1 = new Operation(1, 2, "+");
        Operation op2 = new Operation(3, 2, "gsdsdghf");

        userService.save(user);
        op1.setUser(user);
        op2.setUser(user);
        operationService.save(op1);
        operationService.save(op2);

        operationService.calculator(op1);
        operationService.calculator(op2);

        System.out.println(operationService.findById(1));
        System.out.println(operationService.findById(2));
    }

}
