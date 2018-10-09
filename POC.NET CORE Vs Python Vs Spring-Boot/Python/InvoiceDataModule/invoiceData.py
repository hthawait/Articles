import json
import falcon
import psycopg2
import configparser

class InvoiceData(object):

    def __init__(self,comingFrom):
        print("__init__, comingFrom:",comingFrom)
        config = configparser.ConfigParser()
        config.sections()
        config.read("config.ini")
        
        #Global level variable
        self.DBServer = config['postgresql']['host']
        self.Port = config['postgresql']['port']
        self.Db = config['postgresql']['database']
        self.User = config['postgresql']['user']
        self.Password = config['postgresql']['password']
    
    def getData(self):
        dbConnetion = psycopg2.connect(host=self.DBServer,port=self.Port,user=self.User,password=self.Password,database=self.Db)
        cursor = dbConnetion.cursor()
        sql = sql = "SELECT * FROM public.invoice"
        print("sql:",sql)
        rowCount = cursor.execute(sql)
        rows = cursor.fetchall()
        jsonRows = []
             
        for row in rows:
            jsonRow = {
                'record_id':row[0]
                ,'invoice_number':row[1]
                ,'amount':row[2]
                ,'invoice_description':row[3]
                ,'vendor_name':row[4]
                }
            jsonRows.append(jsonRow)

        cursor.close()
        return (jsonRows)

    def insertData(self):
        dbConnetion = psycopg2.connect(host=self.DBServer,port=self.Port,user=self.User,password=self.Password,database=self.Db)
        cursor = dbConnetion.cursor()
        sql = "INSERT INTO public.invoice(invoice_number, amount, invoice_description, vendor_name) VALUES('invoice_from Python',100,'invoice_description','vendor_name')"
        print("sql:",sql)
        cursor.execute(sql)
        dbConnetion.commit()
        cursor.close()

    def deleteData(self,recordid):
        dbConnetion = psycopg2.connect(host=self.DBServer,port=self.Port,user=self.User,password=self.Password,database=self.Db)
        cursor = dbConnetion.cursor()
        cursor.execute("DELETE FROM public.invoice WHERE record_id =" +  recordid)
        dbConnetion.commit()
        cursor.close()

    def on_get(self, req, resp):
        print("req.query_string:",req.query_string)
        jsonRows = self.getData()
        
        # Create a JSON representation of the resource
        resp.body = json.dumps(jsonRows, ensure_ascii=False)
        resp.status = falcon.HTTP_200

    def on_post(self, req, resp):
        print("Insert data")
        self.insertData()
        resp.body = json.dumps("{result:Data saved.}", ensure_ascii=False)
        resp.status = falcon.HTTP_200

    def on_delete(self, req, resp,recordid):
        print("recordid:",recordid)
        print("req.query_string:",req.query_string)

        self.deleteData(recordid)
        resp.body = json.dumps("{result:Data delete.}", ensure_ascii=False)
        resp.status = falcon.HTTP_200

       