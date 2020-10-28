package model;

public class Report {
	
	public Report(ArrayList<Receipt> report) {
    this.report = report;
	}
	
	public Report() {
    report = new ArrayList<>();
  }
  
  public int getSize() {
    return report.size();
  }
	
	public Receipt getReceipt() {
		return receipt;
	}
  
  public void addReceipt(Receipt receipt) {
    report.add(receipt.clone());
  }
	
	public ArrayList<Receipt> getReport() {
    return report;
  }
  
  public void setReport(ArrayList<Receipt> report) {
    this.report = report;
  }
  
	private ArrayList<Receipt> report;
}
