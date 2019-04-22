<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<meta charset="UTF-8">
<title>登陆</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/login.css">

<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/icon?family=Material+Icons'>

</head>
<body>

<div class="cotn_principal">
  <div class="cont_centrar">
    <div class="cont_login">
      <div class="cont_info_log_sign_up">
        <div class="col_md_login">
          <div class="cont_ba_opcitiy">
            <h2>LOGIN</h2>
            <p>Lorem ipsum dolor sit amet, consectetur.</p>
            <button class="btn_login" onClick="cambiar_login()">LOGIN</button>
          </div>
        </div>
        <div class="col_md_sign_up">
          <div class="cont_ba_opcitiy">
            <h2>SIGN UP</h2>
            <p>Lorem ipsum dolor sit amet, consectetur.</p>
            <button class="btn_sign_up" onClick="cambiar_sign_up()">SIGN UP</button>
          </div>
        </div>
      </div>
      <div class="cont_back_info">
        <div class="cont_img_back_grey"> <img src="${pageContext.request.contextPath}/resource/img/po.jpg" alt="" /> </div>
      </div>



      <div class="cont_forms" >
          <form action="${pageContext.request.contextPath}/common/login" method="post">
        <div class="cont_img_back_"> <img src="${pageContext.request.contextPath}/resource/img/po.jpg" alt="" /> </div>
        <div class="cont_form_login"> <a href="#" onClick="ocultar_login_sign_up()" ><i class="material-icons">&#xE5C4;</i></a>
          <h2>LOGIN</h2>
          <input type="text" placeholder="userName/Email" name="username"/>
          <input type="password" placeholder="Password" name="password"/>
          <button class="btn_login" onClick="cambiar_login()">LOGIN</button>
        </div>
        </form>


          <form action="${pageContext.request.contextPath}/email/send" id="f2" method="post">
        <div class="cont_form_sign_up"> <a href="#" onClick="ocultar_login_sign_up()"><i class="material-icons">&#xE5C4;</i></a>
          <h2>SIGN UP</h2>

          <input type="text" placeholder="Email" name="email"/>
          <input type="text" placeholder="UserName" name="username"/>
          <input type="password" placeholder="Password" name="initPassword"/>
          <input type="password" placeholder="Confirm Password" />
          <button class="btn_sign_up" id="add">SIGN UP</button>
               <%--<input type="submit" class="btn_sign_up" value="SIGN UP">--%>
            <%--<input type="submit" class="btn_sign_up" value="SIGN UP">--%>
        </div>
          </form>
      </div>

    </div>
  </div>
</div>
<script type="text/javascript">

    $(function () {
        $("#add").click(function () {
            alert("666")
            $("#f2").submit();
        })
    })

</script>
<script src="${pageContext.request.contextPath}/resource/js/login.js">

</script>
  
</body>
</html>

