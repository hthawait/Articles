import falcon

from InvoiceDataModule.invoiceData import InvoiceData

# falcon.API instances are callable WSGI apps
app = falcon.API()

# Resources are represented by long-lived class instances
invoiceData = InvoiceData("main")
# things will handle all requests to the '/invoicedata' URL path
app.add_route('/invoicedata', invoiceData)
app.add_route('/invoicedata/{recordid}', invoiceData)

if __name__ == "__main__":
    # Use Python's built-in WSGI reference implementation to run
    # a web server for the application.
    from wsgiref.simple_server import make_server

    # Run the web server on localhost:8080
    print("Starting web app server")
    srv = make_server('localhost', 8080, app)
    srv.serve_forever()


