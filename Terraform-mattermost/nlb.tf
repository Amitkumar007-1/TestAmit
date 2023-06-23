resource "aws_lb_target_group" "mattermost_tg" {
  name     = "mattermost-target-group"
  port     = 8065 #need to change for mattermost port number 8065
  protocol = "TCP"
  vpc_id   = var.vpc_id

}
resource "aws_lb_target_group_attachment" "mattermost_targets" {
  target_group_arn = aws_lb_target_group.mattermost_tg.arn
  target_id        = aws_instance.mattermost.id
  port             = 8065 # Change this to the port on which the target is listening for mattermost 8065
}


resource "aws_lb_listener" "mattermost_listener_https" {
  load_balancer_arn = aws_lb.mattermost-NLB.arn
  port              = 443
  protocol          = "TLS"
  ssl_policy        = "ELBSecurityPolicy-TLS-1-2-2017-01" #"ELBSecurityPolicy-2016-08"
  certificate_arn   = "arn:aws:acm:ap-south-1:948930947331:certificate/b2ab6c06-f3d4-4658-9dee-172b28b86e8e"
  default_action {
    target_group_arn = aws_lb_target_group.mattermost_tg.arn
    type             = "forward"

  }
}

resource "aws_lb" "mattermost-NLB" {
  name               = "mattermost-NLB"
  internal           = false
  load_balancer_type = "network"
  subnets            = [var.subnet_id]
  #enable_deletion_protection = true
}
