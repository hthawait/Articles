using System.Collections.Generic;
using System.Linq;
using CORE.DAL;
using CORE.Models;
using Microsoft.AspNetCore.Mvc;

namespace CORE.Controllers
{

    [Route("api/[controller]")]
    [ApiController]
    public class InvoiceDataController : ControllerBase
    {
        private readonly InvoiceContext _context;

        public InvoiceDataController(InvoiceContext context)
        {
            _context = context;
        }

        // GET api/values
        [HttpGet]
        public ActionResult<IEnumerable<InvoiceModel>> Get()
        {
            return _context.Invoice.ToList();
        }

        // POST api/values
        [HttpPost]
        public void Post()
        {
            InvoiceModel invoice = new InvoiceModel { amount = 100, invoice_description = "invoice_From CORE", invoice_number = "101", vendor_name = "vendor_name" };
            _context.Invoice.Add(invoice);
            _context.SaveChanges();
        }

        // DELETE api/values/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
            InvoiceModel invoice = new InvoiceModel { record_id = id };
            _context.Invoice.Remove(invoice);
            _context.SaveChanges();
        }
    }
}
