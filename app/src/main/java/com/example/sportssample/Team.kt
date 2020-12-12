package com.example.sportssample

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportssample.models.Entry
import com.example.sportssample.models.Player

private const val TAG = "Team"

class Team(private val teams: Entry) : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val list = arrayListOf<Player>()
    private val adapter = TeamAdapter(list)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_team, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter

        return view
    }

    override fun onStart() {
        super.onStart()
        val playerKeys = teams.Players.keys.toList()

        for (k in playerKeys) {
            list.add(teams.Players[k]!!)
        }

        Log.d(TAG, "onStart: $teams")
    }

    private inner class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val playerName: TextView = itemView.findViewById(R.id.playerName)

        /**
         * Filling data in ViewHolders
         */
        fun bind(p: Player) {
            val captain = if (p.isCaptain) " C " else ""
            val keeper = if (p.isKeeper) " WK " else ""
            playerName.text = p.name + " " + captain + " " + keeper
        }
    }

    private inner class TeamAdapter(private val list: List<Player>) :
        RecyclerView.Adapter<TeamViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
            return TeamViewHolder(layoutInflater.inflate(R.layout.team_player_item, parent, false))
        }

        override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
            holder.bind(list[position])
        }

        override fun getItemCount() = list.size

    }


}