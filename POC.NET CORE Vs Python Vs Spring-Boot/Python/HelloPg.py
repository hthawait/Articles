import psycopg2

conn = psycopg2.connect(database="PocDB", user = "dbadmin", password = "dbadminpwd", host = "localhost", port = "5432")

print ("Opened database successfully")

cur = conn.cursor()

cur.execute("SELECT *  from public.invoice")
rows = cur.fetchall()
for row in rows:
   print ("ID = ", row[0])
   print ("NAME = ", row[1])
   print ("ADDRESS = ", row[2])
   print ("SALARY = ", row[3], "\n")

print ("Operation done successfully")
conn.close()
