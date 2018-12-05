<%
	request.setAttribute("contextName", request.getServletContext().getContextPath());
%>
<html>
<head>
<title>Mahasiswa</title>
<link rel="stylesheet" href="${contextName}/assets/bootstrap/css/bootstrap.min.css">
<script src="${contextName}/assets/jquery/jquery-3.3.1.min.js"></script>
<script src="${contextName}/assets/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<form>
		<table>
			<tr>
				<td>NIM</td>
				<td><input type="text" value="" id="nim"></td>
			</tr>
			<tr>
				<td>Nama</td>
				<td><input type="text" value="" id="nama"></td>
			</tr>
			<tr>
				<td>Tanggal Lahir</td>
				<td><input type="text" value="" id="tanggalLahir"></td>
			</tr>
		</table>
	</form>
</body>
</html>