using System.ComponentModel.DataAnnotations;

namespace MvcNews.Models
{
    public class NewsItem
    {
        public int Id { get; set; }
        
        [DataType("DateOnly")]
        public DateTime Timestamp { get; set; }
        
        [Required]
        [StringLength(140, MinimumLength = 5)]
        public string Text { get; set; } = String.Empty;

        [Timestamp]
        public byte[] RowVersion { get; set; } = new byte[0];
    }
}
