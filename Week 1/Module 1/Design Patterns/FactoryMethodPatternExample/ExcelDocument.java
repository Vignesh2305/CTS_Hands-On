package FactoryMethodPatternExample;
class ExcelDocument implements Document
{
	@Override
	public void open()
	{
		System.out.println("Opening excel file");
	}
}