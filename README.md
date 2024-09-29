
Financial Management System with SIP Calculator and Expense Tracking

Features:
Ideal Expenditure Check: The system checks whether the user’s total expenditure exceeds the recommended 40% of their salary. If it does, the system calculates how much they overspent.

SIP Calculator: For any overspending, the system provides a SIP (Systematic Investment Plan) calculator to show how much the user would have gained if they had invested the overspent amount.

How to Use:

Input Salary: The user first inputs their salary.
Log Expenses: The user enters the amount spent on different categories (Food, Clothes, Necessary Items, Miscellaneous) and specifies whether the payment was made online or via cash.
View Balance: The system calculates the user’s remaining balance after expenses.
Check Expenditure: If the user exceeds 40% of their salary in expenses, the system will notify them of the amount overspent.
SIP Calculation: The user can then calculate the future value of that excess amount if invested in a SIP, by providing the annual interest rate and number of years for investment.
Track Online Spending (Optional): Users can track how much they have spent online.

OOP Principles
Object-Oriented Programming concepts:

Abstraction: Used in the Salary class to abstract the concept of salary and expenses.
Encapsulation: Sensitive data such as salary and expenses are kept private and accessed through getter and setter methods.
Polymorphism: Implemented by allowing subclasses like EmployeeSalary to provide specific functionality for tracking online expenses.
Inheritance: Inheritance used in EmployeeSalary class to fetch all details of Salary class. 