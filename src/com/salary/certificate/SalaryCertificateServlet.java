package com.salary.certificate;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

public class SalaryCertificateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String FILE = "";
	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalaryCertificateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hii");
		String name = request.getParameter("name") != null ? request.getParameter("name") : "";
		String location = request.getParameter("location") != null ? request.getParameter("location") : "";
		String cadre = request.getParameter("cadre") != null ? request.getParameter("cadre") : "";
		String office = request.getParameter("office") != null ? request.getParameter("office") : "";
		String purpose = request.getParameter("purpose") != null ? request.getParameter("purpose") : "";
		String pay = request.getParameter("pay") != null ? request.getParameter("pay") : "";
		String da = request.getParameter("da") != null ? request.getParameter("da") : "";
		String hra = request.getParameter("hra") != null ? request.getParameter("hra") : "";
		String hmAllowance = request.getParameter("hmAllowance") != null ? request.getParameter("hmAllowance") : "";
		String ccAllowance = request.getParameter("ccAllowance") != null ? request.getParameter("ccAllowance") : "";
		String ir = request.getParameter("ir") != null ? request.getParameter("ir") : "";
		String payIfAny = request.getParameter("payIfAny") != null ? request.getParameter("payIfAny") : "";
		String pf = request.getParameter("pf") != null ? request.getParameter("pf") : "";
		String pfLoan = request.getParameter("pfLoan") != null ? request.getParameter("pfLoan") : "";
		String apgli = request.getParameter("apgli") != null ? request.getParameter("apgli") : "";
		String apgliLoan = request.getParameter("apgliLoan") != null ? request.getParameter("apgliLoan") : "";
		String gis = request.getParameter("gis") != null ? request.getParameter("gis") : "";
		String pTax = request.getParameter("pTax") != null ? request.getParameter("pTax") : "";
		String ehs = request.getParameter("ehs") != null ? request.getParameter("ehs") : "";
		String lic = request.getParameter("lic") != null ? request.getParameter("lic") : "";
		String it = request.getParameter("it") != null ? request.getParameter("it") : "";
		String reliefFund = request.getParameter("reliefFund") != null ? request.getParameter("reliefFund") : "";
		String swfewf = request.getParameter("swf") != null ? request.getParameter("swf") : "";
		String deductionsIfAny = request.getParameter("deductionsIfAny") != null
				? request.getParameter("deductionsIfAny") : "";
		String netPay = request.getParameter("netPay") != null ? request.getParameter("netPay") : "";
		String dob = request.getParameter("dob") != null ? request.getParameter("dob") : "";
		String dos = request.getParameter("dos") != null ? request.getParameter("dos") : "";
		String dor = request.getParameter("dob") != null ? request.getParameter("dor") : "";
		System.out.println("Name =" + name + ", Location =" + location + ", Cadre =" + cadre + ", office =" + office);
		System.out.println("Purpose =" + purpose + ",pay =" + pay + ", da =" + da + ", hra =" + hra);
		System.out.println("HmAllowance =" + hmAllowance + ", CC Allowance =" + ccAllowance + ", IR=" + ir);
		System.out.println("Pay any =" + payIfAny + ", pf =" + pf + ", pf loan =" + pfLoan + ", apgli =" + apgli);
		System.out.println("Apgli loan =" + apgliLoan + ", gis =" + gis + ", ptax =" + pTax + ", ehs =" + ehs);
		System.out.println("lic =" + lic + ", IT = " + it + ", Relief fund =" + reliefFund + ", swf =" + swfewf);
		System.out.println("deductions if any =" + deductionsIfAny + ", netpay =" + netPay + ", dob =" + dob);
		System.out.println("dos =" + dos + ", dor =" + dor);

		SalaryDto s = new SalaryDto();
		s.setName(name);
		s.setLocation(location);
		s.setCadre(cadre);
		s.setOffice(office);
		s.setPurpose(purpose);
		s.setPay(pay);
		s.setDa(da);
		s.setHra(hra);
		s.setHrAllowance(hmAllowance);
		s.setCcAllowance(ccAllowance);
		s.setIr(ir);
		s.setPayIfAny(payIfAny);
		s.setPf(pf);
		s.setPfLoan(pfLoan);
		s.setApgli(apgliLoan);
		s.setApgliLoan(apgliLoan);
		s.setGis(gis);
		s.setEhs(ehs);
		s.setpTax(pTax);
		s.setLic(lic);
		s.setIt(it);
		s.setSwfewf(swfewf);
		s.setReliefFund(reliefFund);
		s.setDeductionIfAny(deductionsIfAny);
		s.setNetPay(netPay);
		s.setDob(dob);
		s.setDor(dor);
		s.setDos(dos);


		JSONObject o = new JSONObject();

		try {
			Document document = new Document();
			FILE = "/Users/alinizam/Documents/"+s.getName()+"SalaryCertificate.pdf";
			PdfWriter.getInstance(document, new FileOutputStream(FILE));
			document.open();
			addTitlePage(document, s);
			document.close();
			System.out.println("Saved");
			try {
				o.put("result", "success");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Parameters for report

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(o);
		out.flush();
	}

	private static void addTitlePage(Document document, SalaryDto s) throws DocumentException, MalformedURLException, IOException {

		// adding header
		Paragraph preface = new Paragraph();
		addEmptyLine(preface, 1);
		preface.setAlignment(Element.ALIGN_CENTER);
		preface.add(new Paragraph("SALARY CERTIFICATE", catFont));
		addEmptyLine(preface, 1);
		document.add(preface);

		// adding image
		Image image = Image.getInstance("/Users/alinizam/Documents/Nizam.jpeg");
		image.setAbsolutePosition(450f, 700f);
		image.scaleAbsolute(100, 100);
		document.add(image);
		
		
		// Set all parameters
		
		Paragraph name1 = new Paragraph();
		addEmptyLine(name1, 1);
		name1.setAlignment(Element.ALIGN_LEFT);
		name1.add(new Paragraph("NAME                " + s.getName()));
		document.add(name1);
		
		Paragraph name2 = new Paragraph();
		addEmptyLine(name2, 1);
		name2.setAlignment(Element.ALIGN_LEFT);
		name2.add(new Paragraph("LOCATION        " + s.getLocation()));
		document.add(name2);
		
		Paragraph name3 = new Paragraph();
		addEmptyLine(name3, 1);
		name3.setAlignment(Element.ALIGN_LEFT);
		name3.add(new Paragraph("CADRE              " + s.getCadre()));
		document.add(name3);
		
		Paragraph name4 = new Paragraph();
		addEmptyLine(name4, 1);
		name4.setAlignment(Element.ALIGN_LEFT);
		name4.add(new Paragraph("ADDRESS         " + s.getOffice()));
		document.add(name4);
		
		Paragraph name5 = new Paragraph();
		addEmptyLine(name5, 1);
		name5.setAlignment(Element.ALIGN_LEFT);
		name5.add(new Paragraph("PURPOSE         " + s.getPurpose()));
		document.add(name5);
		
		
		Paragraph name6 = new Paragraph();
		addEmptyLine(name6, 1);
		name6.setAlignment(Element.ALIGN_LEFT);
		name6.add(new Paragraph("SALARY                                                                     DEDUCTIONS",smallBold));
		document.add(name6);
		
		LineSeparator ls = new LineSeparator();
		document.add(new Chunk(ls));

		Paragraph name100 = new Paragraph();
		name100.setAlignment(Element.ALIGN_LEFT);
		name100.add(new Paragraph("PAY                                  "+s.getPay()+"                      PF                          "+s.getPf()));
		document.add(name100);
		
		Paragraph name101 = new Paragraph();
		name101.setAlignment(Element.ALIGN_LEFT);
		name101.add(new Paragraph("DA                                    "+s.getDa()+"                              PF LOAN                "+s.getPfLoan()));
		document.add(name101);
		
		Paragraph name102 = new Paragraph();
		name102.setAlignment(Element.ALIGN_LEFT);
		name102.add(new Paragraph("HRA                                 "+s.getHra()+"                                APGLI                     "+s.getApgli()));
		document.add(name102);
		
		Paragraph name105 = new Paragraph();
		name105.setAlignment(Element.ALIGN_LEFT);
		name105.add(new Paragraph("HM ALLOWANCE            "+s.getHrAllowance()+"                           APGLI LOAN           "+s.getApgliLoan()));
		document.add(name105);
		
		Paragraph name104 = new Paragraph();
		name104.setAlignment(Element.ALIGN_LEFT);
		name104.add(new Paragraph("CC ALLOWANCE            "+s.getCcAllowance()+"                                GIS                         "+s.getGis()));
		document.add(name104);
		
		Paragraph name106 = new Paragraph();
		name106.setAlignment(Element.ALIGN_LEFT);
		name106.add(new Paragraph("IR                                     "+s.getIr()+"                              P TAX                     "+s.getpTax()));
		document.add(name106);
		
		Paragraph name107 = new Paragraph();
		name107.setAlignment(Element.ALIGN_LEFT);
		name107.add(new Paragraph("IF ANY                             "+s.getPayIfAny()+"                            EHS                        "+s.getEhs()));
		document.add(name107);
		
		Paragraph name108 = new Paragraph();
		name108.setAlignment(Element.ALIGN_LEFT); 
		name108.add(new Paragraph("                                                                             LIC                          "+s.getLic()));
		document.add(name108);
		
		Paragraph name109 = new Paragraph();
		name109.setAlignment(Element.ALIGN_LEFT);
		name109.add(new Paragraph("                                                                             IT                            "+s.getIt()));
		document.add(name109);
		
		Paragraph name11 = new Paragraph();
		name11.setAlignment(Element.ALIGN_LEFT);
		name11.add(new Paragraph("                                                                             SWF/EWF              "+s.getSwfewf()));
		document.add(name11);
		
		Paragraph name12 = new Paragraph();
		name12.setAlignment(Element.ALIGN_LEFT);
		name12.add(new Paragraph("                                                                             RELIEF FUND        "+s.getReliefFund()));
		document.add(name12);
		
		Paragraph name13 = new Paragraph();
		name13.setAlignment(Element.ALIGN_LEFT);
		name13.add(new Paragraph("                                                                             IF ANY                    "+s.getDeductionIfAny()));
		document.add(name13);
		
		document.add(new Chunk(ls));
		
		Paragraph name14 = new Paragraph();
		name14.setAlignment(Element.ALIGN_LEFT);
		name14.add(new Paragraph("                                                                                      NET PAY                Rs. "+s.getNetPay()+" /-",smallBold));
		document.add(name14);
		
		document.add(new Chunk(ls));
		
		
		Paragraph name16 = new Paragraph();
		addEmptyLine(name16, 1);
		name16.setAlignment(Element.ALIGN_LEFT);
		name16.add(new Paragraph("DATE OF BIRTH                     "+s.getDob()));
		document.add(name16);
		
		Paragraph name15 = new Paragraph();
		
		name15.setAlignment(Element.ALIGN_LEFT);
		name15.add(new Paragraph("DATE OF RETIREMENT         "+s.getDor()));
		document.add(name15);
		
		
		Paragraph name17 = new Paragraph();
		name17.setAlignment(Element.ALIGN_LEFT);
		name17.add(new Paragraph("DATE OF SUBMISSION         "+s.getDos()));
		document.add(name17);
		
		addEmptyLine(name17, 7);
		
		document.add(new Chunk(ls));

	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("12");
		doGet(request, response);
	}

}
