export IMAGE_BASENAME = "antminer"
IMAGE_INSTALL = " \
	busybox \
	base-files \
	base-passwd \
	initscripts \
	sysvinit \
	sysvinit-pidof \
	angstrom-version \
	i2c-tools \
	screen \
	dropbear \
	libcurl \
	lighttpd \
	dtc \
	stunnel \
	openssl \
	mtd-utils \
	curl \
	udev \
	ntp \
	ntpdate \
	netbase \
	avahi \
	led-blink \
"
inherit image
inherit core-image
inherit image_types_uboot


