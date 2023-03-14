using System;

namespace BOL;//namespace App.DTO.Donor

    public class DonorAddDto
    {
        public string DonorName { get; set; }

        public string DonorAddress { get; set; }

        public string DonorMobileNo { get; set; }

        public string DonorEmailId { get; set; }

        public string DonorPassword { get; set; }

        public DonorAddDto(string donorName, string donorAddress, string donorMobileNo, string donorEmailId, string donorPassword)
        {
            DonorName = donorName;
            DonorAddress = donorAddress;
            DonorMobileNo = donorMobileNo;
            DonorEmailId = donorEmailId;
            DonorPassword = donorPassword;
        }

        public DonorAddDto()
        {
        }
    }

