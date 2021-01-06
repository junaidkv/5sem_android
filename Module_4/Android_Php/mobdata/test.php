<?php
	$eno = $_REQUEST["eno"];
	$con = mysqli_connect("localhost:3307","root","");
	if (mysqli_connect_errno($con)) {
      		echo "Failed to connect to MySQL: " . mysqli_connect_error();
   	}
	mysqli_select_db($con,"test");
	$result = mysqli_query($con,"select * from emp where eno=$eno");
	$row = mysqli_fetch_array($result);
	//$arr = Array();
	/*$i=0;
	while($row)
	{
		$arr[$i] = $row;
		$i++;
		$row = mysqli_fetch_row($res);
	}
	echo json_encode($arr);	
	*/
	echo json_encode($row);
?>