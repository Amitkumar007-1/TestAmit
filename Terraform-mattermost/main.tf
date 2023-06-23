resource "aws_instance" "mattermost" {
  #count                       = 1
  ami                         = "ami-0f5ee92e2d63afc18"
  instance_type               = "t2.medium"
  associate_public_ip_address = "true"
  subnet_id                   = var.subnet_id
  vpc_security_group_ids      = [var.security_group_id]
  key_name                    = var.key_name
  user_data                   = file("./bootstrap_script.sh")
  tags = {
    Name = "mattermost"
  }
}

