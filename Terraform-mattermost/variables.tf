variable "vpc_id" {
  type    = string
  default = "vpc-004360fc01cbcbc29"
}

variable "subnet_id" {
  type    = string
  default = "subnet-00de860d84398601f"
}
variable "security_group_id" {
  type    = string
  default = "sg-0ecf309265ccc604d"
}
variable "key_name" {
  type    = string
  default = "mattermost"
}

variable "domain_name" {
  type    = string
  default = "kbtconnect.kanilebettu.in"
}


variable "zone_id" {
  default = "Z0221120RSG766W3M095"
}
