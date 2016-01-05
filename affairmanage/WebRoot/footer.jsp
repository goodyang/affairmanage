<%@page language="java"  pageEncoding="gbk" %>
<div class="copyright">
		<ul>
			<li></li>
			<li>企业日常事务管理系统 &nbsp;&copy;2015-2016</li>
		</ul>
	</div>
	
	<div class="end"></div>
	<script type="text/javascript">
	startajaxtabs("jsmenu");
	var iTab=GetCookie("nets_jsmenu");
	iTab = iTab ? parseInt(iTab):parseInt(Math.random()*5);
	if(iTab!=0) getElement("jsmenu").getElementsByTagName("h1")[iTab].LoadTab();
	iTab++;
	if(iTab>4) iTab=0;
	SetCookie("nets_jsmenu",iTab,365);
	function getElement(aID)
	{
	  return (document.getElementById) ? document.getElementById(aID)
	                                   : document.all[aID];
	}
	</script>
  </body>
</html>

