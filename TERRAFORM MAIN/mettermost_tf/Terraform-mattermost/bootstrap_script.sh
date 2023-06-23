#!bin/bash
sudo su -
cd
#wget https://releases.mattermost.com/5.24.2/mattermost-5.24.2-linux-amd64.tar.gz
wget https://releases.mattermost.com/7.9.1/mattermost-7.9.1-linux-amd64.tar.gz
tar -xvzf mattermost*.gz
sudo mv mattermost /opt
sudo mkdir /opt/mattermost/data
sudo useradd --system --user-group mattermost
sudo chown -R mattermost:mattermost /opt/mattermost
sudo chmod -R g+w /opt/mattermost
sudo wget https://github.com/mattermost/mmctl/releases/download/v7.9.4/linux_amd64.tar
sudo tar -xvf linux_amd64.tar
sudo mv mmctl /usr/local/bin
sudo mmctl version
sudo apt  install jq -y
sudo jq '.ServiceSettings.SiteURL = "https://kbtconnect.kanilebettu.in"' /opt/mattermost/config/config.json > /opt/mattermost/config/temp.json && mv /opt/mattermost/config/temp.json /opt/mattermost/config/config.json
sudo jq '.SqlSettings.DriverName = "postgres"' /opt/mattermost/config/config.json > /opt/mattermost/config/temp.json && mv /opt/mattermost/config/temp.json /opt/mattermost/config/config.json
sudo jq '.SqlSettings.DataSource = "postgres://postgres:kbtrdspswd5200@3.109.101.255:5432/mercodesk-qa?sslmode=disable\u0026search_path=ms_md_mattermost\u0026connect_timeout=10\u0026binary_parameters=yes"' /opt/mattermost/config/config.json > /opt/mattermost/config/temp.json && mv /opt/mattermost/config/temp.json /opt/mattermost/config/config.json 
sudo chown -R mattermost:mattermost /opt/mattermost/*
sudo chmod -R g+w /opt/mattermost/*
sudo echo -e "[Unit]\nDescription=Mattermost\nAfter=network.target\n\n[Service]\nType=notify\nExecStart=/opt/mattermost/bin/mattermost\nTimeoutStartSec=3600\nRestart=always\nRestartSec=10\nWorkingDirectory=/opt/mattermost\nUser=mattermost\nGroup=mattermost\nLimitNOFILE=49152\n\n[Install]\nWantedBy=multi-user.target" | sudo tee /lib/systemd/system/mattermost.service
sudo systemctl daemon-reload
sudo systemctl status mattermost

sudo systemctl restart mattermost
sudo systemctl enable mattermost

