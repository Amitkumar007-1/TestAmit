resource "aws_route53_record" "mattermost_nlb" {
  name    = var.domain_name
  zone_id = var.zone_id
  type    = "A"
  alias {
    name                   = aws_lb.mattermost-NLB.dns_name
    zone_id                = aws_lb.mattermost-NLB.zone_id
    evaluate_target_health = true
  }
}
