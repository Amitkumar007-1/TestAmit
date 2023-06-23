output "aws_instance" {
  value       = aws_instance.mattermost.*.public_ip
  description = "mattermost_public_ip"
}
output "nlb_dns_name" {
  value       = aws_lb.mattermost-NLB.dns_name
  description = "mattermost_DNS_name"
}
output "domain_name" {
  value = aws_route53_record.mattermost_nlb.name
}
