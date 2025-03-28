aws ec2 run-instances \
  --image-id "ami-05c179eced2eb9b5b" \
  --instance-type "t2.medium" \
  --key-name "tf_kp" \
  --network-interfaces '{"SubnetId":"subnet-06d24e7353a89123b","AssociatePublicIpAddress":true,"DeviceIndex":0,"Groups":["sg-0c1c94a22051c3e6e"]}' \
  --credit-specification '{"CpuCredits":"standard"}' \
  --tag-specifications '{"ResourceType":"instance","Tags":[{"Key":"Name","Value":"Jenkins"}]}' \
  --metadata-options '{"HttpEndpoint":"enabled","HttpPutResponseHopLimit":2,"HttpTokens":"required"}' \
  --private-dns-name-options '{"HostnameType":"ip-name","EnableResourceNameDnsARecord":false,"EnableResourceNameDnsAAAARecord":false}' \
  --count 1
