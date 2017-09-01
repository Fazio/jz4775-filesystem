require recipes-bitmianer/image/antminer_base.bb

IMAGE_INSTALL += "minermonitor"
IMAGE_INSTALL += "monitor-ipsig"
IMAGE_INSTALL += "monitor-recobtn"
IMAGE_INSTALL += "cgminer-dash"
IMAGE_INSTALL += "gdb"

export IMAGE_BASENAME = "antminer_m"

