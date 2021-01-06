<?php
	$con = mysqli_connect("localhost:3307","root","");
	if (mysqli_connect_errno($con)) {
      		echo "Failed to connect to MySQL: " . mysqli_connect_error();
   	}
	mysqli_select_db($con,"test");
	$result = mysqli_query($con,"select * from emp");
	$row = mysqli_fetch_array($result);
	$arr = Array();
	$i=0;
	while($row)
	{
		$arr[$i]["eno"] = $row[0];
		$arr[$i]["ename"] = $row[1];
		$i++;
		$row = mysqli_fetch_row($result);
	}
	echo json_encode($arr);	
?>