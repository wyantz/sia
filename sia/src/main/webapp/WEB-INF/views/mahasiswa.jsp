<%
	request.setAttribute("contextName", request.getServletContext().getContextPath());
%>
<html>
<head>
<title>Mahasiswa</title>
<link rel="stylesheet" href="${contextName}/assets/bootstrap/css/bootstrap.min.css">
<script src="${contextName}/assets/jquery/jquery-3.3.1.min.js"></script>
<script src="${contextName}/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="${contextName}/assets/js/default.js"></script>
</head>
<body>
	<center>
	<form id="form-mahasiswa">
		<input type="hidden" id="id" name="id">
		<input type="hidden" id="mode" name="mode">
		<table>
			<tr>
				<td>NIM</td>
				<td><input type="text" id="nim" name="nim"></td>
			</tr>
			<tr>
				<td>Nama</td>
				<td><input type="text" id="nama" name="nama"></td>
			</tr>
			<tr>
				<td>Alamat</td>
				<td><input type="text" id="alamat" name="alamat"></td>
			</tr>
			<tr>
				<td>Tanggal Lahir</td>
				<td><input type="text" id="tanggalLahir" name="tanggalLahir"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" name="submit" id="submit" value="Simpan" onclick="simpanData()"></td>
			</tr>
		</table>
	</form>
	<div id="mahasiswa-list">
	</div>
	</center>
<script>
function simpanData() {
	var tipePost;
	if ($('#mode').val()!='edit') {
		$('#id').val('');
		tipePost='post';
	} else {
		tipePost='put';
	}
	var data = getFormData($('#form-mahasiswa'));
	$.ajax({
		url: '/sia/mahasiswa/',
		type: tipePost,
		dataType: 'json',
		contentType: 'application/json',
		data: JSON.stringify(data),
		success: function(d) {
			loadData();
			$('#mode').val('tambah');
		},
		error: function(d) {
			alert('Error');
		}
	});
}

function loadData() {
	$.ajax({
		url: '/sia/mahasiswa/',
		type: 'get',
		success: function(d) {
			$('#mahasiswa-list').empty();
			var table = $("<table/>");
			var thead = $("<thead/>");
			var tr = $("<tr/>");

			var th = $("<th/>");
			$(th).text("NIM");
			$(tr).append(th);

			th = $("<th/>");
			$(th).text("Nama");
			$(tr).append(th);

			th = $("<th/>");
			$(th).text("Alamat");
			$(tr).append(th);
			$(thead).append(tr);

			$(table).append(thead);
			
			$(d).each(function(index, element) {
				tr = $("<tr/>");
				var td = $("<td/>");
				$(td).text(element.nim);
				$(tr).append(td);
				
				td = $("<td/>");
				$(td).text(element.nama);
				$(tr).append(td);

				td = $("<td/>");
				$(td).text(element.alamat);
				$(tr).append(td);

				td = $("<td/>");
				$(td).html("<a href='#' onclick='edit("+element.id+")' class='btn btn-primary'>Edit</a>");
				$(tr).append(td);

				td = $("<td/>");
				$(td).html("<a href='#' onclick='hapus("+element.id+")' class='btn btn-warning'>Hapus</a>");
				$(tr).append(td);

				$(table).append(tr);
			});
			
			$('#mahasiswa-list').append(table);
		},
		error: function(d) {
		}
	});
}

function edit(id) {
	$.ajax({
		type: "get",
		url: '/sia/mahasiswa/'+id,
		success: function(awi) {
			$('#id').val(awi.id);
			$('#nim').val(awi.nim);
			$('#nama').val(awi.nama);
			$('#alamat').val(awi.alamat);
			$('#tanggalLahir').val(awi.tanggalLahir);
			$('#mode').val('edit');
		},
		error: function(d) {
			alert("Error");
		}
	});
}

function hapus(id) {
	if (confirm('Anda yakin?')) {
		$.ajax({
			type: 'delete',
			url: '/sia/mahasiswa/'+id,
			success: function(d) {
				loadData();
			}
		});
	}
}

$(document).ready(function() {
	loadData();
});
</script>
</body>
</html>