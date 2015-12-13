package net.dv8tion.jda.entities.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.dv8tion.jda.entities.Guild;
import net.dv8tion.jda.entities.User;
import net.dv8tion.jda.entities.VoiceChannel;

public class VoiceChannelImpl implements VoiceChannel
{
    private final String id;
    private final Guild guild;
    private String name;
    private List<User> connectedUsers = new ArrayList<>();

    public VoiceChannelImpl(String id, Guild guild)
    {
        this.id = id;
        this.guild = guild;
    }

    @Override
    public String getId()
    {
        return id;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public Guild getGuild()
    {
        return guild;
    }

    @Override
    public List<User> getUsers()
    {
        return Collections.unmodifiableList(connectedUsers);
    }

    public VoiceChannelImpl setName(String name)
    {
        this.name = name;
        return this;
    }

    public VoiceChannelImpl setUsers(List<User> connectedUsers)
    {
        this.connectedUsers = connectedUsers;
        return this;
    }

    public List<User> getUsersModifiable()
    {
        return connectedUsers;
    }

    /**
     * Returns true if one of the following is true:
     *    A) The provided object is the same VoiceChannel instance as this object
     *    B) The provided object is a VoiceChannel object with the same id as this object.
     *    C) The provided object is a String that is equal to our id.
     */
    @Override
    public boolean equals(Object o)
    {
        if (o instanceof VoiceChannel)
        {
            VoiceChannel oVChannel = (VoiceChannel) o;
            return this == oVChannel || this.getId().equals(oVChannel.getId());
        }
        else if (o instanceof String)
        {
            String oString = (String) o;
            return this.getId().equals(oString);
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        return getId().hashCode();
    }
}