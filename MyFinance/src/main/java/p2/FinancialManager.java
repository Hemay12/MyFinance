package p2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FinancialManager {
	private static int amt;

	public static void main(String[] args) {
		
		System.out.println("Enter your Salary");
		
		Salary salary = new EmployeeSalary();
		Scanner sc = new Scanner(System.in);
		salary.setSalary(sc.nextInt());
		
		String categories[] = {"Food","Clothes","Necessary Items", "Miscellaneous"};
		
		for(String category : categories) {
			System.out.println("Enter the expenditure amount on : "+ category); 
			inputAmount(sc);
			String paymentMethod = checkOnlineOrNot(sc);
			salary.expenses(category, amt, paymentMethod);
		}
		
		System.out.println("Balance is "+salary.Balance());
			
		SIPCalculator sip = new SIPCalculator(salary);
		sip.sipDetails(sc);
		System.out.println(sip.calculateFutureValue());	
		//salary.onlineExpense();
	}

	private static String checkOnlineOrNot(Scanner ik) {
		System.out.println("Payment done Online or Cash. Enter o or c");
		String oc = ik.next();
		return oc.equals("o")?"Online":"Cash";	
	}

	private static void inputAmount(Scanner jk) {
		amt = jk.nextInt();
	}

}

abstract class Salary{
	private int salary;
	public int totalExpenses;
	private Map<String, Integer> expenses = new HashMap<>();
	private Map<String, String> paymentMethods = new HashMap<>();
	
	public int setSalary(int salary) {
		this.salary = salary;
		return this.salary;
	}
	
	abstract public void onlineExpense();

	public int getSalary() {
		return this.salary;	
	}
	
	public void expenses(String cat, int amount, String payment) {
		expenses.put(cat, amount);
		paymentMethods.put(cat,payment);
	}
	
	public double Expen(){
		return this.totalExpenses;
	}
	
	public int Balance() {
		totalExpenses = expenses.values().stream().mapToInt(Integer::intValue).sum();
		return this.salary - totalExpenses;
	}
}

class EmployeeSalary extends Salary  {
	@Override
    public void onlineExpense() {
        //System.out.println("Will be creating this functionality in future");
    }
}

class SIPCalculator {
	
	private Salary salary;
	private double monthlyInvestment;
    private double annualInterestRate;
    private int years;
    
    public SIPCalculator(Salary salary) {
    	this.salary = salary;
    }
    
    public double calculateExcessExpenditure() {
    	double ideal = salary.getSalary()*0.4;
    	
    	if (ideal<salary.totalExpenses) {
    		monthlyInvestment = salary.totalExpenses-ideal;
    		System.out.println("You have spent "+ monthlyInvestment + " more than ideal expenditure");
    		return monthlyInvestment;
    	}
    	return 0;
	}
    
    public void sipDetails(Scanner sc) {
    	System.out.println("Enter the rate of interest per annum");
    	annualInterestRate = sc.nextInt();
    	System.out.println("Enter the number of years you want to invest");
    	years = sc.nextInt();
    }

	public double calculateFutureValue() {
        double r = annualInterestRate / 100 / 12; // Monthly interest rate
        int n = years * 12; // Total number of months
        System.out.println("If you had invested "+monthlyInvestment+" per month for "+years+"years with interest of "+annualInterestRate+"% then value of that would be ");
        return monthlyInvestment * (((Math.pow(1 + r, n) - 1) / r) * (1 + r));
    }
    
}