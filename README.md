# CGMPX
Server Manage Plugin

## Command
	  afk:
	    description: Switched  AFK Enable.
	  back:
		description: Teleport to LastActionPoint.
	  cgm:
	    description: Switched Gamemode.
	    aliases: [gm, gms]
	  god:
	    description: Switched God Enable.
	  fly:
	    description: Switched Fly Enable.
	  heal:
	    description: Will Heal You.
	  nick:
	    description: Set Nickname.
	  forcenick:
	    description: Set the complete Nickname.
	  nickreset:
	    description: Reset Nickname.
	  vanish:
	    description: Switched Vanish.
	  fullvanish:
	    description: Switched Vanish.
	  freeze:
	    description: Freeze players.
	  tp:
	    description: Teleport to Player.
	  tpa:
	    description: Teleport to Player.
	    aliases: [tpall]
	  tphere:
	    description: Teleport to You.
	  serverinfo:
	    description: Show ServerInfo.
	  cgmpdebug:
	    description: PluginDebugCommand.
	    aliases: [dbg]
	  whois:
	    description: Get Player Info.
	    aliases: [ws]
	  workbench:
	    description: Open Workbench.
	    aliases: [wb, wbc]

## Permissions
	  cgmpx.*:
	    children:
	      cgmpx.afk: true
	      cgmpx.back: true
	      cgmpx.cgm: true
	      cgmpx.day: true
	      cgmpx.fly.toggle: true
	      cgmpx.fly.speed: true
	      cgmpx.fly.admin.toggle: true
	      cgmpx.fly.admin.speed: true
	      cgmpx.god: true
	      cgmpx.god.admin: true
	      cgmpx.heal: true
	      cgmpx.heal.admin: true
	      cgmpx.nick: true
	      cgmpx.nick.force: true
	      cgmpx.nick.admin: true
	      cgmpx.day: true
	      cgmpx.vanish: true
	      cgmpx.fullvanish: true
	      cgmpx.vanish.bypass: true
	      cgmpx.freeze: true
	      cgmpx.tp: true
	      cgmpx.tp.all: true
	      cgmpx.tp.here: true
	      cgmpx.sinfo: true
	      cgmpx.wbc: true
	      cgmpx.whois: true
	  cgmpx.god.*:
	    children:
	      cgmpx.god: true
	      cgmpx.god.admin: true
	  cgmpx.fly.*:
	    children:
	      cgmpx.fly.toggle: true
	      cgmpx.fly.speed: true
	      cgmpx.fly.admin.toggle: true
	      cgmpx.fly.admin.speed: true
	  cgmp.fly.admin.*:
	    children:
	      cgmpx.fly.admin.toggle: true
	      cgmpx.fly.admin.speed: true
	  cgmpx.heal.*:
	    children:
	      cgmpx.heal: true
	      cgmpx.heal.admin: true
	  cgmpx.nick.*:
	    children:
	      cgmpx.nick: true
	      cgmpx.nick.force: true
	      cgmpx.nick.admin: true
	  cgmpx.nick.admin.*:
	    children:
	      cgmpx.nick.force: true
	      cgmpx.nick.admin: true
	  cgmpx.tp.*:
	    children:
	      cgmpx.tp: true
	      cgmpx.tp.all: true
	      cgmpx.tp.here: true

### LICENSE
![GNU License Logo](https://www.gnu.org/graphics/gplv3-127x51.png)<br>
LICENSED BY GNU General Public License