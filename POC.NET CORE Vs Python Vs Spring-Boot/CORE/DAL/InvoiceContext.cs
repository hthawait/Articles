using CORE.Models;
using Microsoft.EntityFrameworkCore;

namespace CORE.DAL
{
    public class InvoiceContext : DbContext
    {
        public InvoiceContext(DbContextOptions<InvoiceContext> options) : base(options)
        {
        }
        public DbSet<InvoiceModel> Invoice { get; set; }

    }
}

