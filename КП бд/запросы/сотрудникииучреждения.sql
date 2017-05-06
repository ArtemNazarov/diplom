SELECT snp,employees.city,Institutions.title AS Учреждение,departments.title AS Отдел ,seats.seat,seats.salary
	FROM employees INNER JOIN Institutions 
		ON employees.institution=Institutions.ID
	INNER JOIN Departments 
		ON Departments.ID=Employees.department
	INNER JOIN Seats 
		ON Employees.seat=Seats.ID