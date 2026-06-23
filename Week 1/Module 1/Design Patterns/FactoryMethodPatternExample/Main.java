package FactoryMethodPatternExample;
class Main
{
	public static void main(String[] args)
	{
		System.out.println("Factory Method Demo");
		DocumentFactory wordFactory = new WordDocumentFactory();
		Document wordDocument = wordFactory.createDocument();
		wordDocument.open();
		DocumentFactory pdfFactory = new PdfDocumentFactory();
       		Document pdfDocument = pdfFactory.createDocument();
        	pdfDocument.open();
	        DocumentFactory excelFactory = new ExcelDocumentFactory();
        	Document excelDocument = excelFactory.createDocument();
	        excelDocument.open(); 
	}
}
