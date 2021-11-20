-- Select columns for antenna where measurement is GAIN and antenna code in (list of antenna codes);

SELECT	d.data_id,
		d.date_created,
		d.measurement_code,
		m.name as measurement_name,
		a.antenna_type_code,
		a.description as antenna_desription,
		a.antenna_code,
		a.name as antenna_name,
		d.determinant,
		d.value
FROM data d
INNER JOIN antenna a,
		   measurement m
WHERE d.antenna_code = a.antenna_code
	  AND
	  d.measurement_code = m.measurement_code
	  AND
	  d.antenna_code IN ('ANT001')
	  AND
	  d.measurement_code = 'GAIN'
ORDER BY d.antenna_code,
	  d.determinant;