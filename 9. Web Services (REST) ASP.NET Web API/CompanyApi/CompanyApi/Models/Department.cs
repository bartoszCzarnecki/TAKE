﻿using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

namespace CompanyApi.Models
{
    [Table("Department")]
    public partial class Department
    {
        public Department()
        {
            Subordinate = new HashSet<Employee>();
        }

        [Key]
        public int DepartmentId { get; set; }
        [StringLength(20)]
        [Unicode(false)]
        public string? Name { get; set; }

        [InverseProperty("Department")]
        public virtual ICollection<Employee> Subordinate { get; set; }
    }
}
