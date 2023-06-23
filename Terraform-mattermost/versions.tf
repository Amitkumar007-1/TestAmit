terraform {
  required_version = "~> 1.4.6"
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 4.5.0"
    }
  }
  backend "s3" {
    bucket  = "data-state-tf"
    key     = "terraform.tfstate"
    region  = "ap-south-1"
    encrypt = true
  }
}


provider "aws" {
  region = "ap-south-1"
}
