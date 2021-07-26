/**
 * 재사용성이 높은 코드는 객체로 정의할 수 있다..
	2015년부터는 자바스크립트도 클래스를 지원함~
 */

class Comments{
	constructor(container, msg, cwrite, cdate){
		this.div = document.createElement("div");
		this.t_msg = document.createElement("input");//명시하지 않으면 textfield
		this.t_cwrite = document.createElement("input");
		this.t_cdate = document.createElement("input");
		this.msg;
		this.cwrite;
		this.cdate;


		this.t_msg.style.width=75+"%";
		this.t_msg.readOnly=true;
		this.t_cwrite.style.width=15+"%";
		this.t_cwrite.readOnly=true;
		this.t_cdate.style.width=8+"%";
		this.t_cdate.readOnly=true;
		
		this.t_msg.value=msg;
		this.t_cwrite.value=cwrite;
		this.t_cdate.value=cdate;

		this.div.appendChild(this.t_msg);
		this.div.appendChild(this.t_cwrite);
		this.div.appendChild(this.t_cdate);

		container.appendChild(this.div);
	}
}