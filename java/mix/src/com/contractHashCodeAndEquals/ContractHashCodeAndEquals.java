/**
 * Short theory:
 * -If object1 and object2 are equals by equal(), they have the same hashCode()
 * -If they have the same hashCode its not guarantee of being equal
 *
 * -equal() without overridden method works like == (checks that they have references to the same object)
 */

public class ContractHashCodeAndEquals {

    private static class EmployeeWithOverriddenEqualAndHashCode {

        public EmployeeWithOverriddenEqualAndHashCode(Long employeeId, String firstName, String lastName) {
            this.employeeId = employeeId;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        private Long employeeId;
        private String firstName;
        private String lastName;

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            EmployeeWithOverriddenEqualAndHashCode employeeWithOverriddenEqual = (EmployeeWithOverriddenEqualAndHashCode) o;

            return employeeId == employeeWithOverriddenEqual.employeeId;
        }

        @Override
        public int hashCode() {
            return employeeId.hashCode();
        }

        @Override
        public String toString() {
            return "EmployeeWithOverriddenEqualAndHashCode{" + "employeeId=" + employeeId + ", firstName='" + firstName
                    + '\'' + ", lastName='" + lastName + '\'' + '}' + ", hashcode: @" + Integer.toHexString(hashCode());
        }

    }

    private static class Employee {

        public Employee(Long employeeId, String firstName, String lastName) {
            this.employeeId = employeeId;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        /*
        Copy constructor
         */
        public Employee(Employee copiedEmployee) {
            this.employeeId = copiedEmployee.employeeId;
            this.firstName = copiedEmployee.firstName;
            this.lastName = copiedEmployee.lastName;
        }

        private Long employeeId;
        private String firstName;
        private String lastName;

        @Override
        public String toString() {
            return "Employee{" + "employeeId=" + employeeId + ", firstName='" + firstName + '\'' + ", lastName='"
                    + lastName + '\'' + '}' + ", hashcode: @" + Integer.toHexString(hashCode());
        }

    }

    public static void main(String[] args) {

        /*
        Test with overridden equals & hashcode methods
         */
        EmployeeWithOverriddenEqualAndHashCode emp1 = new EmployeeWithOverriddenEqualAndHashCode(1L, "John1", "Smith2");
        EmployeeWithOverriddenEqualAndHashCode emp2 = new EmployeeWithOverriddenEqualAndHashCode(1L, "John1", "Smith1");
        EmployeeWithOverriddenEqualAndHashCode emp3 = new EmployeeWithOverriddenEqualAndHashCode(2L, "John2", "Smith2");

        System.out.println(emp1.toString());
        System.out.println(emp2.toString());
        System.out.println(emp3.toString());
        System.out.println("emp1.equals(emp2) -> " + emp1.equals(emp2));
        System.out.println("emp1.equals(emp3) -> " + emp1.equals(emp3));
        System.out.println("emp1 == emp2 -> " + (emp1 == emp2));
        System.out.println("emp1 == emp3 -> " + (emp1 == emp3));

        /*
        Test without overridden equals & hashcode methods
         */
        Employee emp4 = new Employee(4L, "John4", "Smith4");
        Employee emp5 = new Employee(4L, "John4", "Smith4");
        Employee emp6 = new Employee(6L, "John6", "Smith6");

        System.out.println("\n" + emp4.toString());
        System.out.println(emp5.toString());
        System.out.println(emp6.toString());
        System.out.println("emp4.equals(emp5) -> " + emp4.equals(emp5));
        System.out.println("emp4.equals(emp6) -> " + emp4.equals(emp6));
        System.out.println("emp4 == emp5 -> " + (emp4 == emp5));
        System.out.println("emp4 == emp6 -> " + (emp4 == emp6));

    }
}