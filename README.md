# CGMPX
Server Manage Plugin

## Command
    cgm:
      description: Switched Gamemode.
      aliases: [gm]
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
    tphere:
      description: Teleport to You.
    serverinfo:
      description: Show ServerInfo.
    cgmpdebug:
      description: PluginDebugCommand.
      aliases: [dbg]

## Permissions
    cgmpx.*:
      children:
        cgmpx.cgm: true
        cgmpx.fly.toggle: true
        cgmpx.fly.speed: true
        cgmpx.fly.admin.toggle: true
        cgmpx.fly.admin.speed: true
        cgmpx.heal: true
        cgmpx.heal.admin: true
        cgmpx.nick: true
        cgmpx.nick.force: true
        cgmpx.nick.admin: true
        cgmpx.vanish: true
        cgmpx.fullvanish: true
        cgmpx.vanish.bypass: true
        cgmpx.freeze: true
        cgmp.tp.here: true
        cgmpx.sinfo: true
    cgmpx.admin.*:
      children:
        cgmpx.cgm: true
        cgmpx.fly.admin.toggle: true
        cgmpx.fly.admin.speed: true
        cgmpx.heal.admin: true
        cgmpx.vanish: true
        cgmpx.fullvanish: true
        cgmpx.vanish.bypass: true
        cgmpx.freeze: true
        cgmp.tp.here: true
        cgmpx.sinfo: true
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
