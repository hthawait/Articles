using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace CORE.Models
{
    [Table("invoice")]
    public class InvoiceModel
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public long record_id { get; set; }
        public string invoice_number { get; set; }
        public double amount { get; set; }
        public string invoice_description { get; set; }
        public string vendor_name { get; set; }
    }
}
