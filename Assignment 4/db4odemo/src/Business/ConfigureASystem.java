package Business;

import Business.Customer.Customer;
import Business.Employee.Employee;
import Business.Role.AdminRole;
import Business.Role.CustomerRole;
import Business.Role.DeliverManRole;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {
    
    static private Organization organization;
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        // organization.setName("org");
        //have some employees 
        //create user account
        
        
        Employee employee = system.getEmployeeDirectory().createEmployee("RRH");
        Employee employee1 = system.getEmployeeDirectory().createEmployee("RRL");
        Employee employee2 = system.getEmployeeDirectory().createEmployee("RRL");
        Employee employee3 = system.getEmployeeDirectory().createEmployee("RRL");
                Employee employee4 = system.getEmployeeDirectory().createEmployee("SSS");


        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());
        
        UserAccount ua1 = system.getUserAccountDirectory().createUserAccount("user", "user", employee1, new CustomerRole());
        UserAccount ua2 = system.getUserAccountDirectory().createUserAccount("delivery", "delivery", employee2, new DeliverManRole());
        UserAccount ua3 = system.getUserAccountDirectory().createUserAccount("manager", "manager", employee3, new AdminRole());
      
        UserAccount ua4 = system.getUserAccountDirectory().createUserAccount("user1", "user1", employee4, new CustomerRole());

        
//  UserAccount ua1 = system.getUserAccountDirectory().createUserAccount("Customer", "Customer", employee1, new CustomerRole());

        //Employee employee2 = organization.getEmployeeDirectory().createEmployee("TEST");
        //organization.getUserAccountDirectory().createUserAccount("user","user",employee2,new CustomerRole());
        
        return system;
    }
    
}
